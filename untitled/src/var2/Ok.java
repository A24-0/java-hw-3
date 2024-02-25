package var2;

public final class Ok<R, E> extends Result<R, E> {
    private final R value;

    public Ok(R value) {
        this.value = value;
    }

    @Override
    public boolean isOk() {
        return true;
    }

    @Override
    public boolean isErr() {
        return false;
    }

    public R getValue() {
        return value;
    }
}
