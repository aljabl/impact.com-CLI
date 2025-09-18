import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
  name = "impact.com",
  description = "Prints impact.com",
  version = "version 1.0"
)

public class ImpactName implements Runnable {

    public static void main(String[] args) {
		int ret;

		ret = new CommandLine(new ImpactName()).execute(args);
		System.exit(ret);
    }

	@Override
	public void run() {
		System.out.println("impact.com");
	}
}
