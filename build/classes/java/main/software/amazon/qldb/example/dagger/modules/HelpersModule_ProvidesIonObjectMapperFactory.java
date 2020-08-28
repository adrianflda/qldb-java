package software.amazon.qldb.example.dagger.modules;

import com.fasterxml.jackson.dataformat.ion.IonObjectMapper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelpersModule_ProvidesIonObjectMapperFactory
    implements Factory<IonObjectMapper> {
  private final HelpersModule module;

  public HelpersModule_ProvidesIonObjectMapperFactory(HelpersModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public IonObjectMapper get() {
    return Preconditions.checkNotNull(
        module.providesIonObjectMapper(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<IonObjectMapper> create(HelpersModule module) {
    return new HelpersModule_ProvidesIonObjectMapperFactory(module);
  }
}
