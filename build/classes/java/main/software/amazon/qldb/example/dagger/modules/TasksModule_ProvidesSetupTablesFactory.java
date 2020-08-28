package software.amazon.qldb.example.dagger.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import software.amazon.qldb.example.actions.tablesmanagement.CreateIndexes;
import software.amazon.qldb.example.actions.tablesmanagement.CreateTables;
import software.amazon.qldb.example.tasks.SetupTables;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class TasksModule_ProvidesSetupTablesFactory implements Factory<SetupTables> {
  private final TasksModule module;

  private final Provider<CreateTables> createTablesProvider;

  private final Provider<CreateIndexes> createIndexesProvider;

  public TasksModule_ProvidesSetupTablesFactory(
      TasksModule module,
      Provider<CreateTables> createTablesProvider,
      Provider<CreateIndexes> createIndexesProvider) {
    assert module != null;
    this.module = module;
    assert createTablesProvider != null;
    this.createTablesProvider = createTablesProvider;
    assert createIndexesProvider != null;
    this.createIndexesProvider = createIndexesProvider;
  }

  @Override
  public SetupTables get() {
    return Preconditions.checkNotNull(
        module.providesSetupTables(createTablesProvider.get(), createIndexesProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SetupTables> create(
      TasksModule module,
      Provider<CreateTables> createTablesProvider,
      Provider<CreateIndexes> createIndexesProvider) {
    return new TasksModule_ProvidesSetupTablesFactory(
        module, createTablesProvider, createIndexesProvider);
  }
}
