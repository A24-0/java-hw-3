package var1;

public class Main {
    public static void main(String[] args) {
        Result<String, Integer> okResult = Result.ok("Success");
        System.out.println("Is ok? " + okResult.isOk());
        System.out.println("Is err? " + okResult.isErr());
        try {
            System.out.println("Unwrap: " + okResult.unwrap());
        } catch (Result.UnwrapFailureException e) {
            System.out.println("Unwrap failed with error: " + e.getMessage());
        }
        System.out.println("Ok or Default: " + okResult.okOrDefault("Default"));
        System.out.println("Err or Default: " + okResult.errOrDefault(-1));

        Result<String, Exception> errResult = Result.err(new Exception("Error"));
        System.out.println("Is ok? " + errResult.isOk());
        System.out.println("Is err? " + errResult.isErr());
        try {
            System.out.println("Unwrap: " + errResult.unwrap());
        } catch (Result.UnwrapFailureException e) {
            System.out.println("Unwrap failed with error: " + e.getMessage());
        }
        System.out.println("Ok or Default: " + errResult.okOrDefault("Default"));
        System.out.println("Err or Default: " + errResult.errOrDefault(new Exception("Default Error")));
    }
}
