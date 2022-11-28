package csci5801grp19;

public abstract class Problem {

    // variables
    int type;
    int language;
    int difficulty;
    String question;
    String answer;

    int getLanguage(String s){

        // pyton
        if(s.equals(".py")){
            this.language = 1;
            return 0;
        }

        // java
        else if(s.equals("py")){
            this.language = 2;
            return 0;
        }
        
        // javascript
        else if(s.equals("py")){
            this.language = 2;
            return 0;
        }

        // HTML
        else if(s.equals("py")){
            this.language = 2;
            return 0;
        }

        // CSS
        else if(s.equals("py")){
            this.language = 2;
            return 0;
        }

        return 1;
    }

}
