package software.amazon.qldb.doubleentry.dagger.modules;

import com.amazonaws.services.qldbsession.AmazonQLDBSessionClientBuilder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DriverClientModule_ProvidesSessionClientBuilderFactory
    implements Factory<AmazonQLDBSessionClientBuilder> {
  private final DriverClientModule module;

  public DriverClientModule_ProvidesSessionClientBuilderFactory(DriverClientModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public AmazonQLDBSessionClientBuilder get() {
    return Preconditions.checkNotNull(
        module.providesSessionClientBuilder(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AmazonQLDBSessionClientBuilder> create(DriverClientModule module) {
    return new DriverClientModule_ProvidesSessionClientBuilderFactory(module);
  }
}
