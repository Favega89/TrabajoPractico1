import java.util.Stack;

/**
 * Created by Yo on 19/3/2018.
 */
public class BeerHouse implements IBuyier,ISeller {

    private Stack<Beer> stock;
    private Beer product;
    private boolean stop;

    public BeerHouse(Stack<Beer> stock) {
        this.stock = stock;
        product = new Beer();
        this.stop = false;
    }

    @Override
    public synchronized void buyBeer(Beer b,String name) {
        while (fullStock()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        this.addBeer(b,name);
        notifyAll();
    }

    private boolean fullStock(){
        if (this.stock.size() < 100)
            return false;
        return true;
    }

    private void addBeer(Beer beer,String producer){
        this.stock.push(beer);
        System.out.println("Se compro cerveza a " + producer + ". El stock ahora es de " +
                this.stock.size() + ".");
    }

    @Override
    public synchronized Beer sellBeer() {
        Beer b = new Beer();
        while(!thereIsBeersOnStock()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        b = this.serveBeer();
        notifyAll();
        return b;
    }

    private boolean thereIsBeersOnStock(){
        if(this.stock.size() > 0)
            return true;
        this.stopBuying();
        return false;
    }

    private Beer serveBeer(){
        if(thereIsBeersOnStock()) {
            product = this.stock.pop();
            System.out.println("Se vendio cerveza, el stock ahora es de "
                    + this.stock.size());
        }else{
            product.noQuedaBirra();
        }
        return product;
    }

    private void stopBuying(){
        this.stop = true;
        System.out.println("YA NO QUEDAN MAS BIRRAS NI GUITA PARA COMPRAR PORQUE EL DUEÑO " +
                "SE HISO TESTIGO DE JEOHVA Y SE LA PATINO EN SOTANAS, CERRO LA BIRRERIA :(");
    }

    public boolean isStop() {
        return stop;
    }
}
