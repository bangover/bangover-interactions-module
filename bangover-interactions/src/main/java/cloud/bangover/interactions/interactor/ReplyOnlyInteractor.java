package cloud.bangover.interactions.interactor;

import cloud.bangover.async.promises.Promise;
import cloud.bangover.timer.Timeout;

/**
 * This interface describes the contract for reply-only interaction mechanism
 * between components.
 *
 * @author Dmitry Mikhaylenko
 *
 * @param <S> The reply type name
 */
public interface ReplyOnlyInteractor<S> {
    /**
     * Invoke a target point. The promise will be resolved if the called target
     * point is handle request and returned response. The promise will be rejected
     * if an error is happened during data delivering or target component returned
     * error response.
     *
     * @return The result promise
     */
    public Promise<S> invoke();
    
    /**
     * This interface declares the contract of creating interactor, bound to the concrete target with
     * specified response type.
     *
     * @author Dmitry Mikhaylenko
     *
     */
    public interface Factory {
      /**
       * Create the interactor with specified parameters.
       *
       * @param <S>          The response type name
       * @param target       The target address
       * @param responseType The response type
       * @param timeout      The response waiting timeout
       * @return The created interactor
       */
      public <S> ReplyOnlyInteractor<S> createInteractor(TargetAddress target, Class<S> responseType, Timeout timeout);
    }
}
