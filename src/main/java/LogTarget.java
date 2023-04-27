import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The LogTarget Class represents a logging target (e.g. console, file, email, server API).
 */
@Data
@AllArgsConstructor
public class LogTarget {
    String target;
}
