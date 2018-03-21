/**
 * Created by Yo on 19/3/2018.
 */
public class Beer {

    private boolean isAnEmptyGlass;

    public Beer() {
        this.isAnEmptyGlass = false;
    }

    public void noQuedaBirra(){
        this.isAnEmptyGlass = true;
    }

   public boolean isAnEmptyGlass(){
        return isAnEmptyGlass;
   }
}
