package cloud.bangover.interactions.interactor;

import cloud.bangover.async.promises.Promise;
import cloud.bangover.timer.Timeout;

/**
 * This interface describes the contract for request-reply interaction mechanism between components.
 *
 * @author Dmitry Mikhaylenko
 * 
 * @param <Q> The request type name
 * @param <S> The reply type name
 */
public interface RequestReplyInteractor<Q, S> {
  /**
   * Invoke a target point. The promise will be resolved if the called target point is handle
   * request and returned response. The promise will be rejected if an error is happened during data
   * delivering or target component returned error response.
   *
   * @param request The request object
   * @return The result promise
   */
  public Promise<S> invoke(Q request);

  /**
   * This interface declares the contract of creating interactor, bound to the concrete target with
   * specified request and response types.
   *
   * @author Dmitry Mikhaylenko
   *
   */
  public interface Factory {
    /**
     * Create the interactor with specified parameters.
     *
     * @param <Q>          The request type name
     * @param <S>          The response type name
     * @param target       The target address
     * @param requestType  The request type
     * @param responseType The response type
     * @param timeout      The response waiting timeout
     * @return The created interactor
     */
    public <Q, S> RequestReplyInteractor<Q, S> createInteractor(TargetAddress target, Class<Q> requestType,
        Class<S> responseType, Timeout timeout);
  }
}
