package var2;

public abstract sealed class Result<R, E> permits Ok, Err {
    public abstract boolean isOk();
    public abstract boolean isErr();

    public static void processResult(Result<?, ?> result) {
        switch (result) {
            case Ok<?, ?> ok -> {
                System.out.println("Success: " + ok.getValue());
            }
            case Err<?, ?> err -> {
                System.out.println("Error: " + err.getError());
            }
        }
    }
    public static <R, E> Result<R, E> ok(R value) {
        return new Ok<>(value);
    }

    public static <R, E> Result<R, E> err(E error) {
        return new Err<>(error);
    }
    public R unwrap() throws UnwrapFailureException{
        if (isOk() && this instanceof Ok<R, E>) {
            return ((Ok<R, E>) this).getValue();
        } else {
            if(this instanceof  Err<R,E>)
                throw new UnwrapFailureException(((Err<R, E>) this).getError());
        }
        return null;
    }

    public static class UnwrapFailureException extends Exception {

        private final Object error;

        public <E> UnwrapFailureException(E error) {
            super("Unable to unwrap value from var2.Result because it contains an error.");
            this.error = error;
        }
        public Object getError() {
            return error;
        }
    }
}

