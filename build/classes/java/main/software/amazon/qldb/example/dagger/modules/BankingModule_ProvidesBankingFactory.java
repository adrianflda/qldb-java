package software.amazon.qldb.example.dagger.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import software.amazon.qldb.example.actions.Banking;
import software.amazon.qldb.example.helpers.IonHelper;
import software.amazon.qldb.example.helpers.TransactionsHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BankingModule_ProvidesBankingFactory implements Factory<Banking> {
  private final BankingModule module;

  private final Provider<TransactionsHandler> transactionsHandlerProvider;

  private final Provider<IonHelper> ionHelperProvider;

  public BankingModule_ProvidesBankingFactory(
      BankingModule module,
      Provider<TransactionsHandler> transactionsHandlerProvider,
      Provider<IonHelper> ionHelperProvider) {
    assert module != null;
    this.module = module;
    assert transactionsHandlerProvider != null;
    this.transactionsHandlerProvider = transactionsHandlerProvider;
    assert ionHelperProvider != null;
    this.ionHelperProvider = ionHelperProvider;
  }

  @Override
  public Banking get() {
    return Preconditions.checkNotNull(
        module.providesBanking(transactionsHandlerProvider.get(), ionHelperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Banking> create(
      BankingModule module,
      Provider<TransactionsHandler> transactionsHandlerProvider,
      Provider<IonHelper> ionHelperProvider) {
    return new BankingModule_ProvidesBankingFactory(
        module, transactionsHandlerProvider, ionHelperProvider);
  }
}
