package cloud.bangover.interactions.interactor;

import lombok.NonNull;

/**
   * This exception notifies about unsupported request type.
   *
   * @author Dmitry Mikhaylenko
   *
   */
  public class WrongRequestTypeException extends RuntimeException {
    private static final long serialVersionUID = -7913320375639849714L;

    public WrongRequestTypeException(@NonNull Class<?> expectedType, @NonNull Object request) {
      super(String.format("Request type %s isn't matched to the expected %s", request.getClass(),
          expectedType));
    }
  }