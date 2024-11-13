package belajarlagi;

public class fieldJava {
    public static void main(String[] args) {
        var person1 = new Person("Hawa ", " Sei Sipai " , 20);
            person1.sayHello("Adam");
            
           Person person2 = new Person("Mara ", "Jianghu" );
           person2.sayHello("Chun Myung");
        var person3 = new Person ("Huo Linger");
           
           person3.sayName("Shi Hao ");   
           
           Person person4;
           person4 = new Person();
           person4.name = "Madara";
           
        System.out.println(person1.name);
        System.out.println(person1.alamat);
        System.out.println(person1.negara);
    }
}
