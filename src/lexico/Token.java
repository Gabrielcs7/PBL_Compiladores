package token;

/**
 *
 * @author Gabriel
 */
public class Token {
    
    private String nome;
    private int pos;
    private int linha;
    private String tipo;

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
    
    
    
    
}
