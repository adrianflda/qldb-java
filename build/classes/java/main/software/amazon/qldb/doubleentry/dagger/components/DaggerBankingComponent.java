package software.amazon.qldb.doubleentry.dagger.components;

import com.amazonaws.services.qldbsession.AmazonQLDBSessionClientBuilder;
import com.fasterxml.jackson.dataformat.ion.IonObjectMapper;
import dagger.internal.Preconditions;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;
import software.amazon.qldb.PooledQldbDriver;
import software.amazon.qldb.doubleentry.actions.Banking;
import software.amazon.qldb.doubleentry.dagger.modules.BankingModule;
import software.amazon.qldb.doubleentry.dagger.modules.BankingModule_ProvidesBankingFactory;
import software.amazon.qldb.doubleentry.dagger.modules.DriverClientModule;
import software.amazon.qldb.doubleentry.dagger.modules.DriverClientModule_ProvidesQLDBDriverFactory;
import software.amazon.qldb.doubleentry.dagger.modules.DriverClientModule_ProvidesSessionClientBuilderFactory;
import software.amazon.qldb.doubleentry.dagger.modules.HelpersModule;
import software.amazon.qldb.doubleentry.dagger.modules.HelpersModule_ProvidesIonHelperFactory;
import software.amazon.qldb.doubleentry.dagger.modules.HelpersModule_ProvidesIonObjectMapperFactory;
import software.amazon.qldb.doubleentry.dagger.modules.HelpersModule_ProvidesTransactionHandlerFactory;
import software.amazon.qldb.doubleentry.dagger.modules.TasksModule;
import software.amazon.qldb.doubleentry.dagger.modules.TasksModule_ProvidesTransferMoneyFactory;
import software.amazon.qldb.doubleentry.helpers.IonHelper;
import software.amazon.qldb.doubleentry.helpers.TransactionsHandler;
import software.amazon.qldb.doubleentry.tasks.TransferMoney;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerBankingComponent implements BankingComponent {
  private Provider<AmazonQLDBSessionClientBuilder> providesSessionClientBuilderProvider;

  private Provider<PooledQldbDriver> providesQLDBDriverProvider;

  private Provider<TransactionsHandler> providesTransactionHandlerProvider;

  private Provider<IonObjectMapper> providesIonObjectMapperProvider;

  private Provider<IonHelper> providesIonHelperProvider;

  private Provider<Banking> providesBankingProvider;

  private Provider<TransferMoney> providesTransferMoneyProvider;

  private DaggerBankingComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static BankingComponent create() {
    return builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.providesSessionClientBuilderProvider =
        ScopedProvider.create(
            DriverClientModule_ProvidesSessionClientBuilderFactory.create(
                builder.driverClientModule));

    this.providesQLDBDriverProvider =
        ScopedProvider.create(
            DriverClientModule_ProvidesQLDBDriverFactory.create(
                builder.driverClientModule, providesSessionClientBuilderProvider));

    this.providesTransactionHandlerProvider =
        HelpersModule_ProvidesTransactionHandlerFactory.create(
            builder.helpersModule, providesQLDBDriverProvider);

    this.providesIonObjectMapperProvider =
        ScopedProvider.create(
            HelpersModule_ProvidesIonObjectMapperFactory.create(builder.helpersModule));

    this.providesIonHelperProvider =
        ScopedProvider.create(
            HelpersModule_ProvidesIonHelperFactory.create(
                builder.helpersModule, providesIonObjectMapperProvider));

    this.providesBankingProvider =
        BankingModule_ProvidesBankingFactory.create(
            builder.bankingModule, providesTransactionHandlerProvider, providesIonHelperProvider);

    this.providesTransferMoneyProvider =
        TasksModule_ProvidesTransferMoneyFactory.create(
            builder.tasksModule, providesBankingProvider);
  }

  @Override
  public TransferMoney providesTransferMoney() {
    return providesTransferMoneyProvider.get();
  }

  public static final class Builder {
    private DriverClientModule driverClientModule;

    private HelpersModule helpersModule;

    private BankingModule bankingModule;

    private TasksModule tasksModule;

    private Builder() {}

    public BankingComponent build() {
      if (driverClientModule == null) {
        this.driverClientModule = new DriverClientModule();
      }
      if (helpersModule == null) {
        this.helpersModule = new HelpersModule();
      }
      if (bankingModule == null) {
        this.bankingModule = new BankingModule();
      }
      if (tasksModule == null) {
        this.tasksModule = new TasksModule();
      }
      return new DaggerBankingComponent(this);
    }

    public Builder tasksModule(TasksModule tasksModule) {
      this.tasksModule = Preconditions.checkNotNull(tasksModule);
      return this;
    }

    public Builder driverClientModule(DriverClientModule driverClientModule) {
      this.driverClientModule = Preconditions.checkNotNull(driverClientModule);
      return this;
    }

    public Builder helpersModule(HelpersModule helpersModule) {
      this.helpersModule = Preconditions.checkNotNull(helpersModule);
      return this;
    }

    public Builder bankingModule(BankingModule bankingModule) {
      this.bankingModule = Preconditions.checkNotNull(bankingModule);
      return this;
    }
  }
}
