package one.digitalInnovation;

public class ArvoreBinaria <T extends Comparable<T>>{

    private BinNO<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(T conteudo){
        BinNO<T> novoNo = new BinNO<>(conteudo);
        raiz = inserir(raiz,novoNo);

    }
    private BinNO<T> inserir(BinNO<T> atual, BinNO<T> novoNO){ //Adiciona mais um nó a lista
        if(atual == null){ //O metodo percorre a lista procurando a posição do novo nó
            return novoNO;
        }else if(novoNO.getConteudo().compareTo(atual.getConteudo())<0){
            //caso o nó atual nao seja null,
            // são comparados os dois nós para determinar se a sua posição esta a esquerda ou a direita

            //enquanto nao achar uma posição de elemento null
            // a chamada recursiva ocorre de novo e novo até acha a posição null
            atual.setNoEsq(inserir(atual.getNoEsq(),novoNO));

        }else{
            atual.setNoDir(inserir(atual.getNoDir(),novoNO));
        }
        return atual;
    }
}
