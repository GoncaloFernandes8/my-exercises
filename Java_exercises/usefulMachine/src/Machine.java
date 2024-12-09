public class Machine {
    public static <T> T performMonoOperation(T operand, MonoOperation<T> operation) {
        return operation.apply(operand);
    }

    public static <T> T performBiOperation(T operand1, T operand2, BiOperation<T> operation) {
        return operation.apply(operand1, operand2);
    }
}
