package software.amazon.qldb.doubleentry.dagger.modules;

import com.amazonaws.services.qldb.AmazonQLDB;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import software.amazon.qldb.doubleentry.actions.ledgermanagement.CreateLedger;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SetupModule_ProvidesCreateLedgerFactory implements Factory<CreateLedger> {
  private final SetupModule module;

  private final Provider<AmazonQLDB> clientProvider;

  public SetupModule_ProvidesCreateLedgerFactory(
      SetupModule module, Provider<AmazonQLDB> clientProvider) {
    assert module != null;
    this.module = module;
    assert clientProvider != null;
    this.clientProvider = clientProvider;
  }

  @Override
  public CreateLedger get() {
    return Preconditions.checkNotNull(
        module.providesCreateLedger(clientProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CreateLedger> create(
      SetupModule module, Provider<AmazonQLDB> clientProvider) {
    return new SetupModule_ProvidesCreateLedgerFactory(module, clientProvider);
  }
}
