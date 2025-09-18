import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(
  name = "impact.com",
  description = "Prints impact.com",
  version = "version 1.0"
)

public class ImpactName implements Runnable {

	/* ANSI colour escape sequences */
	private static final String ESC_CODE = "\u001B[";

	private static final String RESET = ESC_CODE + "0m";
	private static final String DEFAULT = ESC_CODE + "39m";
	private static final String RED = ESC_CODE + "31m";
	private static final String GREEN = ESC_CODE + "32m";
	private static final String YELLOW = ESC_CODE + "33m";
	private static final String BLUE = ESC_CODE + "34m";
	private static final String MAGENTA = ESC_CODE + "35m";
	private static final String CYAN = ESC_CODE + "36m";

	@Parameters(
		index = "0",
		description = "The colour to print the name in: red, green, " +
		              "yellow, blue, magenta, or cyan.",
		arity = "0..1"
	)
	private String colour;


    public static void main(String[] args) {
		int ret;
		int colourCode;

		ret = new CommandLine(new ImpactName()).execute(args);
		System.exit(ret);
    }

	/**
	 * @brief     Returns colour as associated escape sequence.
	 * @param[in] color: user-inputted colour string.
	 * @return    Colour escape sequence (string); default colour on error.
	 */
	private String getColourCode(String colour) {
		switch (colour.toLowerCase()) {
		case "red": return RED;
		case "green": return GREEN;
		case "yellow": return YELLOW;
		case "blue": return BLUE;
		case "magenta": return MAGENTA;
		case "cyan": return CYAN;
		default:
			System.out.println("Invalid colour: " + colour);
			return DEFAULT;
		}
	}

	@Override
	/**
	 * @brief Prints name with style attributes. Called by ImpactName class.
	 * @return None.
	 */
	public void run() {
		String colourCode;

		if (colour == null) {
			System.out.println("impact.com");
			return;
		}

		colourCode = getColourCode(colour);
		System.out.println(colourCode + "impact.com" + RESET);
	}
}
