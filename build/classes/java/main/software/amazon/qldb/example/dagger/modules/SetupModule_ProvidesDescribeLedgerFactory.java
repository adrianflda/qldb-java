package software.amazon.qldb.example.dagger.modules;

import com.amazonaws.services.qldb.AmazonQLDB;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import software.amazon.qldb.example.actions.ledgermanagement.DescribeLedger;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SetupModule_ProvidesDescribeLedgerFactory implements Factory<DescribeLedger> {
  private final SetupModule module;

  private final Provider<AmazonQLDB> clientProvider;

  public SetupModule_ProvidesDescribeLedgerFactory(
      SetupModule module, Provider<AmazonQLDB> clientProvider) {
    assert module != null;
    this.module = module;
    assert clientProvider != null;
    this.clientProvider = clientProvider;
  }

  @Override
  public DescribeLedger get() {
    return Preconditions.checkNotNull(
        module.providesDescribeLedger(clientProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DescribeLedger> create(
      SetupModule module, Provider<AmazonQLDB> clientProvider) {
    return new SetupModule_ProvidesDescribeLedgerFactory(module, clientProvider);
  }
}
