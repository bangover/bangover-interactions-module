package cloud.bangover.interactions.interactor;

import lombok.NonNull;

/**
   * This exception notifies about unsupported response type.
   *
   * @author Dmitry Mikhaylenko
   *
   */
  public class WrongResponseTypeException extends RuntimeException {
    private static final long serialVersionUID = 1708762115152750631L;

    public WrongResponseTypeException(@NonNull Class<?> expectedType, @NonNull Object response) {
      super(String.format("Response type %s isn't matched to the expected %s", response.getClass(),
          expectedType));
    }
  }