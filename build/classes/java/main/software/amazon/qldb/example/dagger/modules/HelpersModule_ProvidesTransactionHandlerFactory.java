package software.amazon.qldb.example.dagger.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import software.amazon.qldb.PooledQldbDriver;
import software.amazon.qldb.example.helpers.TransactionsHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelpersModule_ProvidesTransactionHandlerFactory
    implements Factory<TransactionsHandler> {
  private final HelpersModule module;

  private final Provider<PooledQldbDriver> pooledQldbDriverProvider;

  public HelpersModule_ProvidesTransactionHandlerFactory(
      HelpersModule module, Provider<PooledQldbDriver> pooledQldbDriverProvider) {
    assert module != null;
    this.module = module;
    assert pooledQldbDriverProvider != null;
    this.pooledQldbDriverProvider = pooledQldbDriverProvider;
  }

  @Override
  public TransactionsHandler get() {
    return Preconditions.checkNotNull(
        module.providesTransactionHandler(pooledQldbDriverProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<TransactionsHandler> create(
      HelpersModule module, Provider<PooledQldbDriver> pooledQldbDriverProvider) {
    return new HelpersModule_ProvidesTransactionHandlerFactory(module, pooledQldbDriverProvider);
  }
}
