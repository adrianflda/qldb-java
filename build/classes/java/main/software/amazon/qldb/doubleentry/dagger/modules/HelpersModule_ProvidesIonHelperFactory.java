package software.amazon.qldb.doubleentry.dagger.modules;

import com.fasterxml.jackson.dataformat.ion.IonObjectMapper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import software.amazon.qldb.doubleentry.helpers.IonHelper;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelpersModule_ProvidesIonHelperFactory implements Factory<IonHelper> {
  private final HelpersModule module;

  private final Provider<IonObjectMapper> ionObjectMapperProvider;

  public HelpersModule_ProvidesIonHelperFactory(
      HelpersModule module, Provider<IonObjectMapper> ionObjectMapperProvider) {
    assert module != null;
    this.module = module;
    assert ionObjectMapperProvider != null;
    this.ionObjectMapperProvider = ionObjectMapperProvider;
  }

  @Override
  public IonHelper get() {
    return Preconditions.checkNotNull(
        module.providesIonHelper(ionObjectMapperProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<IonHelper> create(
      HelpersModule module, Provider<IonObjectMapper> ionObjectMapperProvider) {
    return new HelpersModule_ProvidesIonHelperFactory(module, ionObjectMapperProvider);
  }
}
