package software.amazon.qldb.doubleentry.dagger.modules;

import com.amazonaws.services.qldb.AmazonQLDB;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DriverClientModule_ProvidesQLDBClientFactory implements Factory<AmazonQLDB> {
  private final DriverClientModule module;

  public DriverClientModule_ProvidesQLDBClientFactory(DriverClientModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public AmazonQLDB get() {
    return Preconditions.checkNotNull(
        module.providesQLDBClient(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AmazonQLDB> create(DriverClientModule module) {
    return new DriverClientModule_ProvidesQLDBClientFactory(module);
  }
}
