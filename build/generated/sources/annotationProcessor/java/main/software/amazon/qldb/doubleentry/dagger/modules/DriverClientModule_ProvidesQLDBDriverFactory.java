package software.amazon.qldb.doubleentry.dagger.modules;

import com.amazonaws.services.qldbsession.AmazonQLDBSessionClientBuilder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import software.amazon.qldb.PooledQldbDriver;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DriverClientModule_ProvidesQLDBDriverFactory
    implements Factory<PooledQldbDriver> {
  private final DriverClientModule module;

  private final Provider<AmazonQLDBSessionClientBuilder> builderProvider;

  public DriverClientModule_ProvidesQLDBDriverFactory(
      DriverClientModule module, Provider<AmazonQLDBSessionClientBuilder> builderProvider) {
    assert module != null;
    this.module = module;
    assert builderProvider != null;
    this.builderProvider = builderProvider;
  }

  @Override
  public PooledQldbDriver get() {
    return Preconditions.checkNotNull(
        module.providesQLDBDriver(builderProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<PooledQldbDriver> create(
      DriverClientModule module, Provider<AmazonQLDBSessionClientBuilder> builderProvider) {
    return new DriverClientModule_ProvidesQLDBDriverFactory(module, builderProvider);
  }
}
