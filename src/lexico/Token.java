package lexico;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Token implements Comparable<Token> {
    
    private String nome;
    private int pos;
    private int linha;
    private String tipo;
    private boolean temErro;
    String proximos = new String();

    public String getProximos() {
        return proximos;
    }

    public void setProximos(String proximos) {
        this.proximos = proximos;
    }

    
    public boolean isTemErro() {
        return temErro;
    }

    public void setTemErro(boolean temErro) {
        this.temErro = temErro;
    }

    
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Token(String nome, int pos, int linha) {
        this.nome = nome;
        this.pos = pos;
        this.linha = linha;
    }

    public String getNome() {
        return nome;
    }

    public int getPos() {
        return pos;
    }

    public int getLinha() {
        return linha;
    }

    @Override
    public int compareTo(Token o) {
        
        if (this.linha == o.getLinha()){
            if (this.pos > o.getPos()) {
                return 1;
            }
            if (this.pos < o.getPos()) {
                return -1;
            }
        } else{
            if (this.linha > o.getLinha()) {
                return 1;
            }
            if (this.linha < o.getLinha()) {
                return -1;
            }
        }
        
     return 0;
    }
    
    
    
    
}
