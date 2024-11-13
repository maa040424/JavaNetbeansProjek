package belajarlagi;

public class Person {
    String name;
    String alamat;
    final String negara = "Indonesia";
    int umur;

Person(String paramName, String paramAlamat, int paramUmur){
    name = paramName;
    alamat = paramAlamat;
    umur = paramUmur;
}

Person(String paramName, String paramAlamat){
    name = paramName;
    alamat = paramAlamat;
}

Person(String paramName){
    name = paramName;
}

Person(){
}

void sayHello(String paramName){
    System.out.println("Hallo " + paramName + " My Name is , " + name + "dan umurku "+umur);
}
void sayName(String paramName){
    System.out.println("Hallo " + paramName + "My Name is " + name);
}
}
