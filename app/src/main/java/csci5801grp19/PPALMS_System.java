package csci5801grp19;

public class PPALMS_System {

    

    public static void main(String[] args) {
        System.out.println("Hello World!");

        System.out.println("Creating System Facade:");
        SystemFacade facade = SystemFacade.getInstance();


        if(facade.getInput() != 0){
            System.out.println("error");
            return;
        }

        System.out.println("we have gotten the file.");
        System.out.println("title: " + facade.title);
        System.out.println("number of questions: " + facade.questions);
        System.out.println("number of quizzes: " + facade.quizzes);
    }
}
