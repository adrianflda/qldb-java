package software.amazon.qldb.example.dagger.components;

import com.amazonaws.services.qldb.AmazonQLDB;
import com.amazonaws.services.qldbsession.AmazonQLDBSessionClientBuilder;
import dagger.internal.Preconditions;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;
import software.amazon.qldb.PooledQldbDriver;
import software.amazon.qldb.example.actions.ledgermanagement.CreateLedger;
import software.amazon.qldb.example.actions.ledgermanagement.DescribeLedger;
import software.amazon.qldb.example.actions.ledgermanagement.ListLedgers;
import software.amazon.qldb.example.actions.tablesmanagement.CreateIndexes;
import software.amazon.qldb.example.actions.tablesmanagement.CreateTables;
import software.amazon.qldb.example.dagger.modules.DriverClientModule;
import software.amazon.qldb.example.dagger.modules.DriverClientModule_ProvidesQLDBClientFactory;
import software.amazon.qldb.example.dagger.modules.DriverClientModule_ProvidesQLDBDriverFactory;
import software.amazon.qldb.example.dagger.modules.DriverClientModule_ProvidesSessionClientBuilderFactory;
import software.amazon.qldb.example.dagger.modules.HelpersModule;
import software.amazon.qldb.example.dagger.modules.HelpersModule_ProvidesTransactionHandlerFactory;
import software.amazon.qldb.example.dagger.modules.SetupModule;
import software.amazon.qldb.example.dagger.modules.SetupModule_ProvidesCreateIndexesFactory;
import software.amazon.qldb.example.dagger.modules.SetupModule_ProvidesCreateLedgerFactory;
import software.amazon.qldb.example.dagger.modules.SetupModule_ProvidesCreateTablesFactory;
import software.amazon.qldb.example.dagger.modules.SetupModule_ProvidesDescribeLedgerFactory;
import software.amazon.qldb.example.dagger.modules.SetupModule_ProvidesListLedgersFactory;
import software.amazon.qldb.example.dagger.modules.TasksModule;
import software.amazon.qldb.example.dagger.modules.TasksModule_ProvidesSetupLedgerFactory;
import software.amazon.qldb.example.dagger.modules.TasksModule_ProvidesSetupTablesFactory;
import software.amazon.qldb.example.helpers.TransactionsHandler;
import software.amazon.qldb.example.tasks.SetupLedger;
import software.amazon.qldb.example.tasks.SetupTables;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerSetupComponent implements SetupComponent {
  private Provider<AmazonQLDB> providesQLDBClientProvider;

  private Provider<CreateLedger> providesCreateLedgerProvider;

  private Provider<DescribeLedger> providesDescribeLedgerProvider;

  private Provider<ListLedgers> providesListLedgersProvider;

  private Provider<SetupLedger> providesSetupLedgerProvider;

  private Provider<AmazonQLDBSessionClientBuilder> providesSessionClientBuilderProvider;

  private Provider<PooledQldbDriver> providesQLDBDriverProvider;

  private Provider<TransactionsHandler> providesTransactionHandlerProvider;

  private Provider<CreateTables> providesCreateTablesProvider;

  private Provider<CreateIndexes> providesCreateIndexesProvider;

  private Provider<SetupTables> providesSetupTablesProvider;

  private DaggerSetupComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static SetupComponent create() {
    return builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.providesQLDBClientProvider =
        ScopedProvider.create(
            DriverClientModule_ProvidesQLDBClientFactory.create(builder.driverClientModule));

    this.providesCreateLedgerProvider =
        ScopedProvider.create(
            SetupModule_ProvidesCreateLedgerFactory.create(
                builder.setupModule, providesQLDBClientProvider));

    this.providesDescribeLedgerProvider =
        ScopedProvider.create(
            SetupModule_ProvidesDescribeLedgerFactory.create(
                builder.setupModule, providesQLDBClientProvider));

    this.providesListLedgersProvider =
        ScopedProvider.create(
            SetupModule_ProvidesListLedgersFactory.create(
                builder.setupModule, providesQLDBClientProvider));

    this.providesSetupLedgerProvider =
        TasksModule_ProvidesSetupLedgerFactory.create(
            builder.tasksModule,
            providesCreateLedgerProvider,
            providesDescribeLedgerProvider,
            providesListLedgersProvider);

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

    this.providesCreateTablesProvider =
        ScopedProvider.create(
            SetupModule_ProvidesCreateTablesFactory.create(
                builder.setupModule, providesTransactionHandlerProvider));

    this.providesCreateIndexesProvider =
        ScopedProvider.create(
            SetupModule_ProvidesCreateIndexesFactory.create(
                builder.setupModule, providesTransactionHandlerProvider));

    this.providesSetupTablesProvider =
        TasksModule_ProvidesSetupTablesFactory.create(
            builder.tasksModule, providesCreateTablesProvider, providesCreateIndexesProvider);
  }

  @Override
  public SetupLedger providesSetupLedger() {
    return providesSetupLedgerProvider.get();
  }

  @Override
  public SetupTables providesSetupTables() {
    return providesSetupTablesProvider.get();
  }

  public static final class Builder {
    private DriverClientModule driverClientModule;

    private SetupModule setupModule;

    private TasksModule tasksModule;

    private HelpersModule helpersModule;

    private Builder() {}

    public SetupComponent build() {
      if (driverClientModule == null) {
        this.driverClientModule = new DriverClientModule();
      }
      if (setupModule == null) {
        this.setupModule = new SetupModule();
      }
      if (tasksModule == null) {
        this.tasksModule = new TasksModule();
      }
      if (helpersModule == null) {
        this.helpersModule = new HelpersModule();
      }
      return new DaggerSetupComponent(this);
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

    public Builder setupModule(SetupModule setupModule) {
      this.setupModule = Preconditions.checkNotNull(setupModule);
      return this;
    }
  }
}
