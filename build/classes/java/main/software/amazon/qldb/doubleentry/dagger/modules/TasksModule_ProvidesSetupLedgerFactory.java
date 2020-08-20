package software.amazon.qldb.doubleentry.dagger.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import software.amazon.qldb.doubleentry.actions.ledgermanagement.CreateLedger;
import software.amazon.qldb.doubleentry.actions.ledgermanagement.DescribeLedger;
import software.amazon.qldb.doubleentry.actions.ledgermanagement.ListLedgers;
import software.amazon.qldb.doubleentry.tasks.SetupLedger;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TasksModule_ProvidesSetupLedgerFactory implements Factory<SetupLedger> {
  private final TasksModule module;

  private final Provider<CreateLedger> createLedgerProvider;

  private final Provider<DescribeLedger> describeLedgerProvider;

  private final Provider<ListLedgers> listLedgersProvider;

  public TasksModule_ProvidesSetupLedgerFactory(
      TasksModule module,
      Provider<CreateLedger> createLedgerProvider,
      Provider<DescribeLedger> describeLedgerProvider,
      Provider<ListLedgers> listLedgersProvider) {
    assert module != null;
    this.module = module;
    assert createLedgerProvider != null;
    this.createLedgerProvider = createLedgerProvider;
    assert describeLedgerProvider != null;
    this.describeLedgerProvider = describeLedgerProvider;
    assert listLedgersProvider != null;
    this.listLedgersProvider = listLedgersProvider;
  }

  @Override
  public SetupLedger get() {
    return Preconditions.checkNotNull(
        module.providesSetupLedger(
            createLedgerProvider.get(), describeLedgerProvider.get(), listLedgersProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SetupLedger> create(
      TasksModule module,
      Provider<CreateLedger> createLedgerProvider,
      Provider<DescribeLedger> describeLedgerProvider,
      Provider<ListLedgers> listLedgersProvider) {
    return new TasksModule_ProvidesSetupLedgerFactory(
        module, createLedgerProvider, describeLedgerProvider, listLedgersProvider);
  }
}
