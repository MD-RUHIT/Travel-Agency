import javax.swing.UIManager;

public class Start{
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        new FirstPage();
    }
}