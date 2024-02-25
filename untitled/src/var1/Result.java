package var1;

public class Result<R, E> {
    private final R value;
    private final E error;
    private final boolean isOk;

    private Result(R value, E error, boolean isOk) {
        this.value = value;
        this.error = error;
        this.isOk = isOk;
    }

    public static <R, E> Result<R, E> ok(R value) {
        return new Result<>(value, null, true);
    }

    public static <R, E> Result<R, E> err(E error) {
        return new Result<>(null, error, false);
    }

    public boolean isOk() {
        return isOk;
    }

    public boolean isErr() {
        return !isOk;
    }

    public R unwrap() throws UnwrapFailureException {
        if (isOk) {
            return value;
        } else {
            throw new UnwrapFailureException(error);
        }
    }

    public R okOrDefault(R defaultValue) {
        return isOk ? value : defaultValue;
    }

    public E errOrDefault(E defaultError) {
        return isOk ? null : error != null ? error : defaultError;
    }
    public static class UnwrapFailureException extends Exception {

        private final Object error;

        public <E> UnwrapFailureException(E error) {
            super("Unable to unwrap value from var1.Result because it contains an error.");
            this.error = error;
        }
        public Object getError() {
            return error;
        }
    }

}
