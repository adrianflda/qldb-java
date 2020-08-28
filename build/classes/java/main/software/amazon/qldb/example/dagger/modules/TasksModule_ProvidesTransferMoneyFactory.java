package software.amazon.qldb.example.dagger.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import software.amazon.qldb.example.actions.Banking;
import software.amazon.qldb.example.tasks.TransferMoney;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TasksModule_ProvidesTransferMoneyFactory implements Factory<TransferMoney> {
  private final TasksModule module;

  private final Provider<Banking> bankingProvider;

  public TasksModule_ProvidesTransferMoneyFactory(
      TasksModule module, Provider<Banking> bankingProvider) {
    assert module != null;
    this.module = module;
    assert bankingProvider != null;
    this.bankingProvider = bankingProvider;
  }

  @Override
  public TransferMoney get() {
    return Preconditions.checkNotNull(
        module.providesTransferMoney(bankingProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<TransferMoney> create(
      TasksModule module, Provider<Banking> bankingProvider) {
    return new TasksModule_ProvidesTransferMoneyFactory(module, bankingProvider);
  }
}
