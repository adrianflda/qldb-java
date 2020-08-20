package software.amazon.qldb.doubleentry.dagger.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import software.amazon.qldb.doubleentry.helpers.IonHelper;
import software.amazon.qldb.doubleentry.helpers.SampleData;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelpersModule_ProvidesSampleDataFactory implements Factory<SampleData> {
  private final HelpersModule module;

  private final Provider<IonHelper> ionHelperProvider;

  public HelpersModule_ProvidesSampleDataFactory(
      HelpersModule module, Provider<IonHelper> ionHelperProvider) {
    assert module != null;
    this.module = module;
    assert ionHelperProvider != null;
    this.ionHelperProvider = ionHelperProvider;
  }

  @Override
  public SampleData get() {
    return Preconditions.checkNotNull(
        module.providesSampleData(ionHelperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SampleData> create(
      HelpersModule module, Provider<IonHelper> ionHelperProvider) {
    return new HelpersModule_ProvidesSampleDataFactory(module, ionHelperProvider);
  }
}
