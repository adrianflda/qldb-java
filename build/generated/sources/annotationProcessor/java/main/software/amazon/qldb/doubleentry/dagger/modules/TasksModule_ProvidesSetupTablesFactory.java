package software.amazon.qldb.doubleentry.dagger.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import software.amazon.qldb.doubleentry.actions.tablesmanagement.CreateIndexes;
import software.amazon.qldb.doubleentry.actions.tablesmanagement.CreateTables;
import software.amazon.qldb.doubleentry.actions.tablesmanagement.LoadSampleData;
import software.amazon.qldb.doubleentry.tasks.SetupTables;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TasksModule_ProvidesSetupTablesFactory implements Factory<SetupTables> {
  private final TasksModule module;

  private final Provider<CreateTables> createTablesProvider;

  private final Provider<CreateIndexes> createIndexesProvider;

  private final Provider<LoadSampleData> loadSampleDataProvider;

  public TasksModule_ProvidesSetupTablesFactory(
      TasksModule module,
      Provider<CreateTables> createTablesProvider,
      Provider<CreateIndexes> createIndexesProvider,
      Provider<LoadSampleData> loadSampleDataProvider) {
    assert module != null;
    this.module = module;
    assert createTablesProvider != null;
    this.createTablesProvider = createTablesProvider;
    assert createIndexesProvider != null;
    this.createIndexesProvider = createIndexesProvider;
    assert loadSampleDataProvider != null;
    this.loadSampleDataProvider = loadSampleDataProvider;
  }

  @Override
  public SetupTables get() {
    return Preconditions.checkNotNull(
        module.providesSetupTables(
            createTablesProvider.get(), createIndexesProvider.get(), loadSampleDataProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SetupTables> create(
      TasksModule module,
      Provider<CreateTables> createTablesProvider,
      Provider<CreateIndexes> createIndexesProvider,
      Provider<LoadSampleData> loadSampleDataProvider) {
    return new TasksModule_ProvidesSetupTablesFactory(
        module, createTablesProvider, createIndexesProvider, loadSampleDataProvider);
  }
}
