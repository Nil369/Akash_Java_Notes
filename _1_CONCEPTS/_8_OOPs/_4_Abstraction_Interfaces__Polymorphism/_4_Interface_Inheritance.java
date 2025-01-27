@SuppressWarnings("unused")
interface sampleInterface{
    void meth1();
    void meth2();
}

@SuppressWarnings("unused")
interface childSampleInterface extends sampleInterface{
    void meth3();
    void meth4();
}

class MySampleClass implements childSampleInterface{
    @Override
    public void meth1(){
        System.out.println("meth1");
    }
    @Override
    public void meth2(){
        System.out.println("meth2");
    }
    @Override
    public void meth3(){
        System.out.println("meth3");
    }
    @Override
    public void meth4(){
        System.out.println("meth4");
    }
}

public class _4_Interface_Inheritance {
    public static void main(String[] args) {
        MySampleClass obj = new MySampleClass();
        obj.meth1();
        obj.meth2();
        obj.meth3();
    }
}
