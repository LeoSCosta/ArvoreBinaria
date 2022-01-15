package one.digitalInnovation;

import one.digitalInnovation.model.Obj;

public class Main {
    public static void main(String[] args) {

        ArvoreBinaria<Obj> arvore = new ArvoreBinaria<>();

        arvore.inserir(new Obj(13));
        arvore.inserir(new Obj(10));
        arvore.inserir(new Obj(25));
        arvore.inserir(new Obj(2));
        arvore.inserir(new Obj(12));
        arvore.inserir(new Obj(20));
        arvore.inserir(new Obj(31));
        arvore.inserir(new Obj(29));

        arvore.inOrdem();
        arvore.posOrdem();
        arvore.preOrdem();

    }
}
