package var2;

public class Main {
    public static void main(String[] args) {
        Result<Integer, String> okResult = Result.ok(100);
        Result<Integer, String> errResult = Result.err("Ошибка выполнения");

        Result.processResult(okResult);
        Result.processResult(errResult);
        try {
            System.out.println("Unwrap: " + okResult.unwrap());
        } catch (Result.UnwrapFailureException e) {
            System.out.println("Unwrap failed with error: " + e.getMessage());
        }
    }
}
