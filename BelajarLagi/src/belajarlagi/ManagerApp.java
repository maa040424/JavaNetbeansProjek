package belajarlagi;

public class ManagerApp {
    public static void main(String[] args) {
        var manager = new Manager();
            manager.name = " Adam";
            manager.sayHello("Hawa ");
            
        var VicePre = new vicePresident();
            VicePre.name = " Huo Linger ";
            VicePre.sayHello("Shi Hao");
    }
}
