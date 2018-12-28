/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

import java.util.ArrayList;
import lexico.Token;

/**
 *
 * @author Aloisio
 */
public class AnalisadorSemantico {

    private ArrayList<Classe> classes = new ArrayList();
    private ArrayList<Constante> constantes = new ArrayList();
    private ArrayList errosSemanticos = new ArrayList();

    public AnalisadorSemantico() {
    }

    // FUNÇÃO PRINCIPAL, RESPONSAVEL POR EXECUTAR O PRINCIPAL DO SEMANTICO
    public void executaSemantico(ArrayList<Token> listaFinal) {

        classificaEstruturas(listaFinal); // Constroi as estruturas necessárias para a análise semântica
        verificaTiposConstante(); // Verifica se as constantes recebem valores de acordo com o seu tipo
        printConstIncorrectValue(); // Imprime os erros de tipagem-valor das constantes
        putMetodosVariaveisPaiFilho(); // Altera as classes, colocando os métodos e atributos das classes que herdam de outra, caso exista
        verificaSeConstEAtribuidaFora(listaFinal);

    }

    // Método responsável por fazer a classificação das estruturas pra análise léxica
    public void classificaEstruturas(ArrayList<Token> listaFinal) {

        criaConstantes(listaFinal);

        criaClasses(listaFinal);

    }

    // Metodo responsável por fazer a sepação das classes para a classificação semântica
    public void criaClasses(ArrayList<Token> listaFinal) {

        int i, numClasses = 0;

        for (i = 0; i < listaFinal.size(); i++) {
            if (listaFinal.get(i).getTipo().equals("Palavra Reservada") && listaFinal.get(i).getNome().equals("class")) {
                i++;
                Classe classe = new Classe();
                if (listaFinal.get(i).getTipo().equals("Identificador") && listaFinal.get(i).isTemErro() == false) {
                    classe.setNome(listaFinal.get(i).getNome());
                } else {
                    classe.setNome("classe" + numClasses + "SemNome");
                }

                ArrayList<Token> auxList = new ArrayList();

                i++;

                if (listaFinal.get(i).getNome().equals("extends")) {
                    i++;
                    if (listaFinal.get(i).isTemErro() == false && listaFinal.get(i).getTipo().equals("Identificador")) {
                        classe.setHeranca(listaFinal.get(i).getNome());
                        i++;
                    }
                }

                if (listaFinal.get(i).getNome().equals("{")) {
                    i++;
                } else {
                    break;
                }

                while (listaFinal.get(i).getNome().equals("class") || i != listaFinal.size()) {
                    auxList.add(listaFinal.get(i));
                    i++;
                }

                i--;

                ArrayList<Variavel> variaveisClasse = new ArrayList();
                ArrayList<Metodo> metodosClasse = new ArrayList();

                criaVariaveis(auxList, variaveisClasse);
                criaMetosos(auxList, metodosClasse);

                //int j = i+1;
                /*
                    int auxInt = 0;
                    boolean auxFor = false;
                    Stack pilha = new Stack();
                    String auxString;
       
                    for (int k = j; k<listaFinal.size(); k++){
                        if (listaFinal.get(k).getNome().equals("(") && listaFinal.get(k).isTemErro() == false){
                            auxString = (String)pilha.push(listaFinal.get(k).getNome());
                            auxInt++;
                        } else {
                            break;
                        }
                        
                        if (listaFinal.get(k).getNome().equals(")") && listaFinal.get(k).isTemErro() == false){
                            auxString = (String)pilha.pop();
                            auxInt--;
                        } else {
                            break;
                        }
                    }
                 */
                getClasses().add(numClasses, classe);
                numClasses++;

            } else {
                break;
            }
        }

    }

    public void criaConstantes(ArrayList<Token> listaFinal) {
        int i;

        for (i = 0; i < listaFinal.size(); i++) {
            if (listaFinal.get(i).getTipo().equals("Palavra Reservada") && listaFinal.get(i).getNome().equals("const")) {
                i++;
                Constante constAux = new Constante();
                if (listaFinal.get(i).getNome().equals("{")) {
                    i++;
                    while (!listaFinal.get(i).getNome().equals("}") || i < listaFinal.size() || !listaFinal.get(i).getNome().equals("class")) {
                        if (listaFinal.get(i).getTipo().equals("Palavra Reservada") && listaFinal.get(i).getNome().equals("int")) {
                            i++;
                            ArrayList<Constante> listaConstAux = new ArrayList();
                            while (!listaFinal.get(i).getTipo().equals("Palavra Reservada") || listaFinal.get(i).getNome().equals(";")) {
                                String nomeAux;
                                int linhaNoCodigo;
                                if (listaFinal.get(i).getTipo().equals("Identificador")) {
                                    nomeAux = listaFinal.get(i).getNome();
                                    linhaNoCodigo = listaFinal.get(i).getLinha();
                                    i++;
                                    if (listaFinal.get(i).getNome().equals("=")) {
                                        i++;
                                        if (listaFinal.get(i).getTipo().equals("Identificador")) {
                                            Constante constanteAux = new Constante();
                                            constanteAux.setNome(nomeAux);
                                            constanteAux.setTipo("int");
                                            constanteAux.setValor(listaFinal.get(i).getNome());
                                            constanteAux.setLinhaNoCodigo(linhaNoCodigo);
                                            i++;
                                            if (listaFinal.get(i).getNome().equals(",")) {
                                                i++;
                                                getConstantes().add(constanteAux);
                                            }
                                            //ATENÇÃO!!!! DEVE SER VERIFICADO SE PODE UMA VIRGULA SEGUIDA DO PONTO-VIRGULA
                                            if (listaFinal.get(i).getNome().equals(";")) {
                                                getConstantes().add(constanteAux);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }

                        } else if (listaFinal.get(i).getTipo().equals("Palavra Reservada") && listaFinal.get(i).getNome().equals("float")) {
                            i++;
                            ArrayList<Constante> listaConstAux = new ArrayList();

                            while (!listaFinal.get(i).getTipo().equals("Palavra Reservada") || listaFinal.get(i).getNome().equals(";")) {
                                String nomeAux;
                                int linhaNoCodigo;
                                if (listaFinal.get(i).getTipo().equals("Identificador")) {
                                    nomeAux = listaFinal.get(i).getNome();
                                    linhaNoCodigo = listaFinal.get(i).getLinha();
                                    i++;
                                    if (listaFinal.get(i).getNome().equals("=")) {
                                        i++;
                                        if (listaFinal.get(i).getTipo().equals("Identificador")) {
                                            Constante constanteAux = new Constante();
                                            constanteAux.setNome(nomeAux);
                                            constanteAux.setTipo("float");
                                            constanteAux.setValor(listaFinal.get(i).getNome());
                                            constanteAux.setLinhaNoCodigo(linhaNoCodigo);
                                            i++;
                                            if (listaFinal.get(i).getNome().equals(",")) {
                                                i++;
                                                getConstantes().add(constanteAux);
                                            }
                                            //ATENÇÃO!!!! DEVE SER VERIFICADO SE PODE UMA VIRGULA SEGUIDA DO PONTO-VIRGULA
                                            if (listaFinal.get(i).getNome().equals(";")) {
                                                getConstantes().add(constanteAux);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }

                        } else if (listaFinal.get(i).getTipo().equals("Palavra Reservada") && listaFinal.get(i).getNome().equals("string")) {
                            i++;
                            while (!listaFinal.get(i).getTipo().equals("Palavra Reservada") || listaFinal.get(i).getNome().equals(";")) {
                                String nomeAux;
                                int linhaNoCodigo;
                                if (listaFinal.get(i).getTipo().equals("Identificador")) {
                                    nomeAux = listaFinal.get(i).getNome();
                                    linhaNoCodigo = listaFinal.get(i).getLinha();
                                    i++;
                                    if (listaFinal.get(i).getNome().equals("=")) {
                                        i++;
                                        if (listaFinal.get(i).getTipo().equals("Cadeia de caracteres")) {
                                            Constante constanteAux = new Constante();
                                            constanteAux.setNome(nomeAux);
                                            constanteAux.setTipo("string");
                                            constanteAux.setValor(listaFinal.get(i).getNome());
                                            constanteAux.setLinhaNoCodigo(linhaNoCodigo);
                                            i++;
                                            if (listaFinal.get(i).getNome().equals(",")) {
                                                i++;
                                                getConstantes().add(constanteAux);
                                            }
                                            //ATENÇÃO!!!! DEVE SER VERIFICADO SE PODE UMA VIRGULA SEGUIDA DO PONTO-VIRGULA
                                            if (listaFinal.get(i).getNome().equals(";")) {
                                                getConstantes().add(constanteAux);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }

                        } else if (listaFinal.get(i).getTipo().equals("Palavra Reservada") && listaFinal.get(i).getNome().equals("bool")) {
                            i++;
                            while (!listaFinal.get(i).getTipo().equals("Palavra Reservada") || listaFinal.get(i).getNome().equals(";")) {
                                String nomeAux;
                                int linhaNoCodigo;
                                if (listaFinal.get(i).getTipo().equals("Identificador")) {
                                    nomeAux = listaFinal.get(i).getNome();
                                    linhaNoCodigo = listaFinal.get(i).getLinha();
                                    i++;
                                    if (listaFinal.get(i).getNome().equals("=")) {
                                        i++;
                                        if (listaFinal.get(i).getTipo().equals("Palavra Reservada") && (listaFinal.get(i).getNome().equals("true") || listaFinal.get(i).getNome().equals("false"))) {
                                            Constante constanteAux = new Constante();
                                            constanteAux.setNome(nomeAux);
                                            constanteAux.setTipo("bool");
                                            constanteAux.setValor(listaFinal.get(i).getNome());
                                            constanteAux.setLinhaNoCodigo(linhaNoCodigo);
                                            i++;
                                            if (listaFinal.get(i).getNome().equals(",")) {
                                                i++;
                                                getConstantes().add(constanteAux);
                                            }
                                            //ATENÇÃO!!!! DEVE SER VERIFICADO SE PODE UMA VIRGULA SEGUIDA DO PONTO-VIRGULA
                                            if (listaFinal.get(i).getNome().equals(";")) {
                                                getConstantes().add(constanteAux);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    }
                    if (listaFinal.get(i).getNome().equals("}") || !(i < listaFinal.size()) || listaFinal.get(i).getNome().equals("class")) {
                        break;
                    }
                }
            }
        }
    }

    public void criaVariaveis(ArrayList<Token> listaAux, ArrayList<Variavel> variaveis) {
        int i;

        for (i = 0; i < listaAux.size(); i++) {
            if (listaAux.get(i).getTipo().equals("Palavra Reservada") && listaAux.get(i).getNome().equals("variables")) {
                i++;
                if (listaAux.get(i).getNome().equals("{")) {
                    i++;
                    while (!listaAux.get(i).getNome().equals("}") || i < listaAux.size() || !listaAux.get(i).getNome().equals("class")) {
                        if (listaAux.get(i).getTipo().equals("Palavra Reservada") && listaAux.get(i).getNome().equals("int")) {
                            i++;
                            while (!listaAux.get(i).getTipo().equals("Palavra Reservada") || listaAux.get(i).getNome().equals(";")) {
                                String nomeAux;
                                int linhaNoCodigo;
                                if (listaAux.get(i).getTipo().equals("Identificador")) {
                                    nomeAux = listaAux.get(i).getNome();
                                    linhaNoCodigo = listaAux.get(i).getLinha();

                                    Variavel variavelAux = new Variavel();
                                    variavelAux.setNome(nomeAux);
                                    variavelAux.setTipo("int");
                                    variavelAux.setLinhaNoCodigo(linhaNoCodigo);
                                    i++;

                                    if (listaAux.get(i).getNome().equals(",")) {
                                        i++;
                                        variaveis.add(variavelAux);
                                    }
                                    //ATENÇÃO!!!! DEVE SER VERIFICADO SE PODE UMA VIRGULA SEGUIDA DO PONTO-VIRGULA
                                    if (listaAux.get(i).getNome().equals(";")) {
                                        variaveis.add(variavelAux);
                                        break;
                                    }
                                }
                            }

                        } else if (listaAux.get(i).getTipo().equals("Palavra Reservada") && listaAux.get(i).getNome().equals("float")) {
                            i++;
                            while (!listaAux.get(i).getTipo().equals("Palavra Reservada") || listaAux.get(i).getNome().equals(";")) {
                                String nomeAux;
                                int linhaNoCodigo;
                                if (listaAux.get(i).getTipo().equals("Identificador")) {
                                    nomeAux = listaAux.get(i).getNome();
                                    linhaNoCodigo = listaAux.get(i).getLinha();

                                    Variavel variavelAux = new Variavel();
                                    variavelAux.setNome(nomeAux);
                                    variavelAux.setTipo("float");
                                    variavelAux.setLinhaNoCodigo(linhaNoCodigo);
                                    i++;

                                    if (listaAux.get(i).getNome().equals(",")) {
                                        i++;
                                        variaveis.add(variavelAux);
                                    }
                                    //ATENÇÃO!!!! DEVE SER VERIFICADO SE PODE UMA VIRGULA SEGUIDA DO PONTO-VIRGULA
                                    if (listaAux.get(i).getNome().equals(";")) {
                                        variaveis.add(variavelAux);
                                        break;
                                    }
                                }
                            }

                        } else if (listaAux.get(i).getTipo().equals("Palavra Reservada") && listaAux.get(i).getNome().equals("string")) {
                            i++;
                            while (!listaAux.get(i).getTipo().equals("Palavra Reservada") || listaAux.get(i).getNome().equals(";")) {
                                String nomeAux;
                                int linhaNoCodigo;
                                if (listaAux.get(i).getTipo().equals("Identificador")) {
                                    nomeAux = listaAux.get(i).getNome();
                                    linhaNoCodigo = listaAux.get(i).getLinha();

                                    Variavel variavelAux = new Variavel();
                                    variavelAux.setNome(nomeAux);
                                    variavelAux.setTipo("string");
                                    variavelAux.setLinhaNoCodigo(linhaNoCodigo);
                                    i++;
                                    if (listaAux.get(i).getNome().equals(",")) {
                                        i++;
                                        variaveis.add(variavelAux);
                                    }
                                    //ATENÇÃO!!!! DEVE SER VERIFICADO SE PODE UMA VIRGULA SEGUIDA DO PONTO-VIRGULA
                                    if (listaAux.get(i).getNome().equals(";")) {
                                        variaveis.add(variavelAux);
                                        break;
                                    }
                                }
                            }

                        } else if (listaAux.get(i).getTipo().equals("Palavra Reservada") && listaAux.get(i).getNome().equals("bool")) {
                            i++;
                            while (!listaAux.get(i).getTipo().equals("Palavra Reservada") || listaAux.get(i).getNome().equals(";")) {
                                String nomeAux;
                                int linhaNoCodigo;
                                if (listaAux.get(i).getTipo().equals("Identificador")) {
                                    nomeAux = listaAux.get(i).getNome();
                                    linhaNoCodigo = listaAux.get(i).getLinha();
                                    
                                    Variavel variavelAux = new Variavel();
                                    variavelAux.setNome(nomeAux);
                                    variavelAux.setTipo("bool");
                                    variavelAux.setLinhaNoCodigo(linhaNoCodigo);
                                    i++;
                                    if (listaAux.get(i).getNome().equals(",")) {
                                        i++;
                                        variaveis.add(variavelAux);
                                    }
                                    //ATENÇÃO!!!! DEVE SER VERIFICADO SE PODE UMA VIRGULA SEGUIDA DO PONTO-VIRGULA
                                    if (listaAux.get(i).getNome().equals(";")) {
                                        variaveis.add(variavelAux);
                                        break;
                                    }
                                }
                            }

                        }
                    }
                    if (listaAux.get(i).getNome().equals("}") || !(i < listaAux.size()) || listaAux.get(i).getNome().equals("class")) {
                        break;
                    }
                }
            }
        }
    }

    public void criaMetosos(ArrayList<Token> listaAux, ArrayList<Metodo> metodos) {
    }

    public void classificaFuncao(int i) {
    }

    public void classificaExpressao(int i) {
    }

    // Método responsável por fazer a atribuição de métodos e atributos de classes "filho" que herdam do "pai"
    public void putMetodosVariaveisPaiFilho() {

        int i;
        String stringAux;

        for (i = 0; i < classes.size(); i++) {

            if (!(classes.get(i).getHeranca().isEmpty())) {

                stringAux = classes.get(i).getHeranca();
                Classe classeAux = null;
                int j = 0;
                while (classeAux == null) {
                    if (classes.get(j).getNome().equals(stringAux)) {
                        classeAux = classes.get(j);
                    }
                    j++;
                }
                // Faz a adição de métodos e variáveis da classe pai para a filha
                classes.get(i).getVariaveis().addAll(0,classeAux.getVariaveis());
                classes.get(i).getMetodos().addAll(0,classeAux.getMetodos());

                Variavel auxVariavel;
                int auxInt = classes.get(i).getVariaveis().size();
                
                // Faz verificação se adicionou variáveis já existentes
                for (int k=0; k<auxInt; k++){
                    auxVariavel = classes.get(i).getVariaveis().get(k);
                    int intAux = 0;
                    while (intAux<auxInt){
                        String auxString = classes.get(i).getVariaveis().get(intAux).getNome();
                        if (auxVariavel.getNome().equals(auxString) && k!=intAux){
                            classes.get(i).getVariaveis().remove(intAux);
                        } else {
                            intAux++;
                        } 
                    }
                }
                
                // Faz a subescrita e sobrecarga de métodos da classe "mãe" para a classe "filha"
                Metodo auxMetodo;
                auxInt = classes.get(i).getMetodos().size();
                for (int k=0; k<auxInt; k++){
                    auxMetodo = classes.get(i).getMetodos().get(k);
                    int intAux = 0;
                    while (intAux<auxInt){
                        Metodo auxMetodo2 = classes.get(i).getMetodos().get(intAux);
                        if (auxMetodo.getNome().equals(auxMetodo2.getNome()) && k!=intAux){
                            if (auxMetodo2.getTipoRetorno().equals(auxMetodo.getTipoRetorno())){
                                if (auxMetodo.getParametros().size() == auxMetodo2.getParametros().size()){
                                    boolean auxBool = true;
                                    for (int a=0; a<auxMetodo.getParametros().size(); a++){
                                        if (!auxMetodo.getParametros().get(a).getTipo().equals(auxMetodo2.getParametros().get(a).getTipo())){
                                            auxBool = false;
                                            break;
                                        }
                                    }
                                    if (auxBool == true){
                                        classes.get(i).getMetodos().remove(intAux);
                                    } else {
                                    }
                                }
                            } else {
                                // Como só é permitido a sobrecarga com o mesmo nome e tipo de retorno, retira o método que pertence a classe "filha"
                                classes.get(i).getMetodos().remove(intAux);
                            }
                        } else {
                            intAux++;
                        }
                    }
                }
            }
        }
    }

    // Método que verifica se é atribuida um valor a constante fora do campo "const"
    public void verificaSeConstEAtribuidaFora(ArrayList<Token> listaFinal) {

        int i, j;

        for (i = 0; i < listaFinal.size(); i++) {
            if (listaFinal.get(i).getNome().equals("class")) {
                i++;
                for (j = i; j < listaFinal.size(); j++) {
                    if (verificaSeConstExiste(listaFinal.get(j).getNome())) {
                        j++;
                        if (listaFinal.get(j).getNome().equals("=")) {
                            System.out.print("A constante '" + listaFinal.get(j).getNome() + "' está sendo atribuída valor fora do escopo 'const' do arquivo de texto.");
                            j++;
                        }
                    }
                }
            }
        }

    }

    // Método responsável por fazer a verificação se existe uma constante declarada com o nome recebido em parâmetro
    public boolean verificaSeConstExiste(String nomeConst) {
        boolean retorno = false;
        int i;
        //Varre a lista de constantes e verifica um a um
        for (i = 0; i < getConstantes().size(); i++) {
            if (getConstantes().get(i).getNome().equals(nomeConst)) { // Se a constante em análise for igual ao nome da string recebida como parametro, retorna true
                retorno = true;
                break;
            }
        }
        return retorno;
    }

    // Verifica o tipo das variáveis e e se o valor delas está de acordo com o tipo
    public void verificaTiposVariaveis(ArrayList<Variavel> variaveis) {

        int i;
        int auxInt;
        float auxFloat;
        boolean auxBool;
        String auxString;
        String aux;
        for (i = 0; i < variaveis.size(); i++) {
            switch (variaveis.get(i).getTipo()) {

                case "int":
                    aux = variaveis.get(i).getValor();
                    auxInt = 0;
                    try {
                        auxInt = Integer.parseInt(aux);
                    } catch (NumberFormatException e) {
                        variaveis.get(i).setValorIsCorrect(false);
                    } finally {
                        if (auxInt != 0) {
                            variaveis.get(i).setValorIsCorrect(true);
                        }
                    }
                    break;

                case "float":
                    aux = variaveis.get(i).getValor();
                    auxFloat = 0;
                    try {
                        auxFloat = Float.parseFloat(aux);
                    } catch (NumberFormatException e) {
                        variaveis.get(i).setValorIsCorrect(false);
                    } finally {
                        if (auxFloat != 0) {
                            variaveis.get(i).setValorIsCorrect(true);
                        }
                    }
                    break;

                case "bool":
                    aux = variaveis.get(i).getValor();
                    if (aux.equals("false") || aux.equals("true")) {
                        variaveis.get(i).setValorIsCorrect(true);
                    } else {
                        variaveis.get(i).setValorIsCorrect(false);
                    }
                    break;

                case "string":
                    break;

                default:
                    break;
            }
        }

    }

    public void atribuiValorVariaveis() {

        for (int i = 0; i < getClasses().size(); i++) {
            int auxNum = getClasses().get(i).getVariaveis().size();
            while (auxNum != 0) {
                
            }
        }

    }

    public void verificaTiposConstante() {
        int i;
        int auxInt;
        float auxFloat;
        boolean auxBool;
        String auxString;
        String aux;
        for (i = 0; i < getConstantes().size(); i++) {
            switch (getConstantes().get(i).getTipo()) {

                case "int":
                    aux = getConstantes().get(i).getValor();
                    auxInt = 0;
                    try {
                        auxInt = Integer.parseInt(aux);
                    } catch (NumberFormatException e) {
                        getConstantes().get(i).setIsCorrectValue(false);
                    } finally {
                        if (auxInt != 0) {
                            getConstantes().get(i).setIsCorrectValue(true);
                        }
                    }
                    break;

                case "float":
                    aux = getConstantes().get(i).getValor();
                    auxFloat = 0;
                    try {
                        auxFloat = Float.parseFloat(aux);
                    } catch (NumberFormatException e) {
                        getConstantes().get(i).setIsCorrectValue(false);
                    } finally {
                        if (auxFloat != 0) {
                            getConstantes().get(i).setIsCorrectValue(true);
                        }
                    }
                    break;

                case "bool":
                    aux = getConstantes().get(i).getValor();
                    if (aux.equals("false") || aux.equals("true")) {
                        getConstantes().get(i).setIsCorrectValue(true);
                    } else {
                        getConstantes().get(i).setIsCorrectValue(false);
                    }
                    break;

                case "string":
                    break;

                default:
                    break;
            }
        }
    }

    public void printConstIncorrectValue() {
        int i;
        boolean aux;
        ArrayList<Constante> constantesIncorretas = new ArrayList();
        for (i = 0; i < getConstantes().size(); i++) {
            aux = false;
            if (getConstantes().get(i).isIsCorrectValue() == false) {
                aux = constantesIncorretas.add(getConstantes().get(i));
                if (aux == false) {
                    break;
                }
            }
        }

        for (i = 0; i < constantesIncorretas.size(); i++) {
            System.out.print("A constante '" + constantesIncorretas.get(i).getNome() + "'[LINHA:" + constantesIncorretas.get(i).getLinhaNoCodigo() + "] recebeu um valor diferente do tipo '" + constantesIncorretas.get(i).getTipo() + "'.");
        }
        constantesIncorretas.clear();
    }

    /**
     * @return the classes
     */
    public ArrayList<Classe> getClasses() {
        return classes;
    }

    /**
     * @param classes the classes to set
     */
    public void setClasses(ArrayList<Classe> classes) {
        this.classes = classes;
    }

    /**
     * @return the constantes
     */
    public ArrayList<Constante> getConstantes() {
        return constantes;
    }

    /**
     * @param constantes the constantes to set
     */
    public void setConstantes(ArrayList<Constante> constantes) {
        this.constantes = constantes;
    }

    /**
     * @return the errosSemanticos
     */
    public ArrayList getErrosSemanticos() {
        return errosSemanticos;
    }

    /**
     * @param errosSemanticos the errosSemanticos to set
     */
    public void setErrosSemanticos(ArrayList errosSemanticos) {
        this.errosSemanticos = errosSemanticos;
    }

}
