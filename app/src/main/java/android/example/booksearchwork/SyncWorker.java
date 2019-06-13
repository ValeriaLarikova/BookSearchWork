package android.example.booksearchwork;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class SyncWorker extends Worker {

    @NonNull
    @Override
    public Result doWork() {
        Repository repository = ((BookApp)getApplicationContext()).getRepository();
        Log.e("Worker","Working!");
        return Result.success();
    }

    public SyncWorker(Context context, WorkerParameters params){ super(context,params); }
}

