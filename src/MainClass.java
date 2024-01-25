
public class MainClass {
    public static void main(String[] args) {
        String name = "CPM_mini.";
        Input input = new Input();
        input.readData(name + "hrn");

        System.out.println("Hran: " + input.getPocetHran());
        System.out.println("Vrcholov: " + input.getPocetVrchol());

        var mcp = new CPM(input, name + "tim");


    }
}
