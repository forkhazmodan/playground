package concurrent.loadbalancer.v3;

import java.util.Objects;

public class BackendInstance {

  private String ip;
  private Integer weight = 1;

  public BackendInstance(String ip) {
    this.ip = ip;
  }

  public BackendInstance(String ip, Integer weight) {
    this.ip = ip;
    this.weight = weight <= 0 ? this.weight : weight;
  }

  public String getIp() {
    return ip;
  }

  public Integer getWeight() {
    return weight;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BackendInstance that = (BackendInstance) o;
    return Objects.equals(ip, that.ip);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(ip);
  }

  @Override
  public String toString() {
    return "BackendInstance{" +
        "ip='" + ip + '\'' +
        '}';
  }
}
