package software.amazon.qldb.doubleentry.dagger.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import software.amazon.qldb.doubleentry.actions.tablesmanagement.LoadSampleData;
import software.amazon.qldb.doubleentry.helpers.IonHelper;
import software.amazon.qldb.doubleentry.helpers.SampleData;
import software.amazon.qldb.doubleentry.helpers.TransactionsHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelpersModule_ProvidesLoadSampleDataFactory implements Factory<LoadSampleData> {
  private final HelpersModule module;

  private final Provider<TransactionsHandler> transactionsHandlerProvider;

  private final Provider<SampleData> sampleDataProvider;

  private final Provider<IonHelper> ionHelperProvider;

  public HelpersModule_ProvidesLoadSampleDataFactory(
      HelpersModule module,
      Provider<TransactionsHandler> transactionsHandlerProvider,
      Provider<SampleData> sampleDataProvider,
      Provider<IonHelper> ionHelperProvider) {
    assert module != null;
    this.module = module;
    assert transactionsHandlerProvider != null;
    this.transactionsHandlerProvider = transactionsHandlerProvider;
    assert sampleDataProvider != null;
    this.sampleDataProvider = sampleDataProvider;
    assert ionHelperProvider != null;
    this.ionHelperProvider = ionHelperProvider;
  }

  @Override
  public LoadSampleData get() {
    return Preconditions.checkNotNull(
        module.providesLoadSampleData(
            transactionsHandlerProvider.get(), sampleDataProvider.get(), ionHelperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<LoadSampleData> create(
      HelpersModule module,
      Provider<TransactionsHandler> transactionsHandlerProvider,
      Provider<SampleData> sampleDataProvider,
      Provider<IonHelper> ionHelperProvider) {
    return new HelpersModule_ProvidesLoadSampleDataFactory(
        module, transactionsHandlerProvider, sampleDataProvider, ionHelperProvider);
  }
}
