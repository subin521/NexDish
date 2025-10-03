import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val db = Firebase.firestore
//
//        // 🔸 쓰기
//        db.collection("ping").document("hello")
//            .set(mapOf("msg" to "NexDish Firestore OK", "ts" to System.currentTimeMillis()))
//            .addOnSuccessListener { Log.d("NexDish", "write OK") }
//            .addOnFailureListener { e -> Log.e("NexDish", "write FAIL", e) }
//
//        // 🔸 읽기
//        db.collection("ping").document("hello")
//            .get()
//            .addOnSuccessListener { snap -> Log.d("NexDish", "read: ${snap.data}") }
//            .addOnFailureListener { e -> Log.e("NexDish", "read FAIL", e) }
//
//        setContent { /* TODO: Compose UI */ }
    }
}
