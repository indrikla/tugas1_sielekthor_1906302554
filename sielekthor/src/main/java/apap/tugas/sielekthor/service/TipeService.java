package apap.tugas.sielekthor.service;
import java.util.List;
import java.util.Optional;

import apap.tugas.sielekthor.model.TipeModel;

public interface TipeService {
    List<TipeModel> getTipeList();
    TipeModel findByNamaTipe(String namaTipe);

}
