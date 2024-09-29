import simulation.Simulator;

public class Main {

    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                System.out.println("Usage: java Simulator <filename>");
                System.exit(1);
            }
            Simulator sim = new Simulator();
            sim.setScenario(args[0]);
            sim.runSimulation();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
