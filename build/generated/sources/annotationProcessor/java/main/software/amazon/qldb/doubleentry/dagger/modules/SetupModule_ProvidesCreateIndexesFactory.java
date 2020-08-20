package software.amazon.qldb.doubleentry.dagger.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import software.amazon.qldb.doubleentry.actions.tablesmanagement.CreateIndexes;
import software.amazon.qldb.doubleentry.helpers.TransactionsHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SetupModule_ProvidesCreateIndexesFactory implements Factory<CreateIndexes> {
  private final SetupModule module;

  private final Provider<TransactionsHandler> transactionsHandlerProvider;

  public SetupModule_ProvidesCreateIndexesFactory(
      SetupModule module, Provider<TransactionsHandler> transactionsHandlerProvider) {
    assert module != null;
    this.module = module;
    assert transactionsHandlerProvider != null;
    this.transactionsHandlerProvider = transactionsHandlerProvider;
  }

  @Override
  public CreateIndexes get() {
    return Preconditions.checkNotNull(
        module.providesCreateIndexes(transactionsHandlerProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CreateIndexes> create(
      SetupModule module, Provider<TransactionsHandler> transactionsHandlerProvider) {
    return new SetupModule_ProvidesCreateIndexesFactory(module, transactionsHandlerProvider);
  }
}
