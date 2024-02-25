package var2;

public final class Err<R, E> extends Result<R, E> {
    private final E error;

    public Err(E error) {
        this.error = error;
    }

    @Override
    public boolean isOk() {
        return false;
    }

    @Override
    public boolean isErr() {
        return true;
    }

    public E getError() {
        return error;
    }
}
