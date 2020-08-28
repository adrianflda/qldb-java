package software.amazon.qldb.example.dagger.modules;

import com.amazonaws.services.qldb.AmazonQLDB;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import software.amazon.qldb.example.actions.ledgermanagement.ListLedgers;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SetupModule_ProvidesListLedgersFactory implements Factory<ListLedgers> {
  private final SetupModule module;

  private final Provider<AmazonQLDB> clientProvider;

  public SetupModule_ProvidesListLedgersFactory(
      SetupModule module, Provider<AmazonQLDB> clientProvider) {
    assert module != null;
    this.module = module;
    assert clientProvider != null;
    this.clientProvider = clientProvider;
  }

  @Override
  public ListLedgers get() {
    return Preconditions.checkNotNull(
        module.providesListLedgers(clientProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ListLedgers> create(
      SetupModule module, Provider<AmazonQLDB> clientProvider) {
    return new SetupModule_ProvidesListLedgersFactory(module, clientProvider);
  }
}
