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
            //enquanto não achar uma posição de elemento null
            // a chamada recursiva ocorre de novo e novo até achar uma posição null
            atual.setNoEsq(inserir(atual.getNoEsq(),novoNO));

        }else{
            atual.setNoDir(inserir(atual.getNoDir(),novoNO));
        }
        return atual;
    }

    //________________________________________________________________________________________
    public void remover(T conteudo){
        try {
            BinNO<T> atual = this.raiz;
            BinNO<T> pai = null;
            BinNO<T> filho;
            BinNO<T> temp;

            while (atual != null && !atual.getConteudo().equals(conteudo)){
                pai = atual;
                if(conteudo.compareTo(atual.getConteudo())<0){
                    atual = atual.getNoEsq();
                }else{
                    atual = atual.getNoDir();
                }
            }
            if (atual == null){
                System.out.println("conteudo não existe");
            }

            assert atual != null;
            if(pai == null){
                if(atual.getNoDir() == null){
                    this.raiz = atual.getNoEsq();
                }else if (atual.getNoEsq() == null){
                    this.raiz = atual.getNoDir();
                }else{
                    for(temp = atual, filho = atual.getNoEsq();
                        filho.getNoDir() != null;
                        temp = filho, filho = filho.getNoEsq()
                    ){
                        if(filho != atual.getNoEsq()){
                            temp.setNoDir(filho.getNoEsq());
                            filho.setNoEsq(raiz.getNoEsq());
                        }
                    }
                    filho.setNoDir(raiz.getNoDir());
                    raiz = filho;

                }

            }else {
                if(atual.getNoDir() == null){
                    if(pai.getNoDir() == atual ){
                        pai.setNoEsq(atual.getNoEsq());
                    }else{
                        pai.setNoDir(atual.getNoEsq());
                    }

                }else if(atual.getNoEsq() == null){
                    if(pai.getNoEsq() == null){
                        pai.setNoEsq(atual.getNoDir());
                    }else{
                        pai.setNoDir(atual.getNoDir());
                    }
                }else{
                    for(
                            temp = atual, filho = atual.getNoEsq();
                            filho.getNoDir() != null;
                            temp = filho, filho = filho.getNoDir()
                    ){

                        if(filho != atual.getNoEsq()){
                            temp.setNoDir(filho.getNoEsq());
                            filho.setNoEsq(atual.getNoEsq());
                        }
                        filho.setNoDir(atual.getNoDir());
                        if(pai.getNoEsq() == atual){
                            pai.setNoEsq(filho);
                        }else{
                            pai.setNoDir(filho);
                        }
                    }

                }
            }

        }catch (NullPointerException erro){
            System.out.println("Conteudo não encontrado");
        }
    }

    //________________________________________________________________________________________

    public void inOrdem(){
        System.out.println("\nExibindo inOrdem");
        inOrdem(this.raiz);
    }

    private void inOrdem(BinNO<T> raiz) {
        if(raiz != null){
            inOrdem(raiz.getNoEsq());
            System.out.print(raiz.getConteudo() + ",");
            inOrdem(raiz.getNoDir());
        }
    }

    //________________________________________________________________________________________
    public void posOrdem(){
        System.out.println("\nExibindo posOrdem");
        posOrdem(this.raiz);
    }

    private void posOrdem(BinNO<T> raiz) {
        if(raiz != null){
            posOrdem(raiz.getNoEsq());
            posOrdem(raiz.getNoDir());
            System.out.print(raiz.getConteudo() + ",");
        }
    }

    //________________________________________________________________________________________
    public void preOrdem(){
        System.out.println("\nExibindo preOrdem");
        preOrdem(this.raiz);
    }

    private void preOrdem(BinNO<T> raiz) {
        if(raiz != null){
            System.out.print(raiz.getConteudo() + ",");
            preOrdem(raiz.getNoEsq());
            preOrdem(raiz.getNoDir());
        }
    }


}
