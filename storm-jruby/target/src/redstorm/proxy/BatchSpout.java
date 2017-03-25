package redstorm.proxy;

import org.jruby.Ruby;
import org.jruby.RubyObject;
import org.jruby.runtime.Helpers;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.javasupport.JavaUtil;
import org.jruby.RubyClass;
import backtype.storm.task.TopologyContext;
import storm.trident.operation.TridentCollector;
import storm.trident.spout.IBatchSpout;
import backtype.storm.tuple.Fields;
import java.util.Map;


public class BatchSpout extends RubyObject implements IBatchSpout {
    private static final Ruby __ruby__ = Ruby.getGlobalRuntime();
    private static final RubyClass __metaclass__;

    static {
        String source = new StringBuilder("require 'java'\n" +
            "\n" +
            "java_import 'backtype.storm.task.TopologyContext'\n" +
            "java_import 'storm.trident.operation.TridentCollector'\n" +
            "java_import 'storm.trident.spout.IBatchSpout'\n" +
            "java_import 'backtype.storm.tuple.Fields'\n" +
            "java_import 'java.util.Map'\n" +
            "\n" +
            "module Backtype\n" +
            "  java_import 'backtype.storm.Config'\n" +
            "end\n" +
            "\n" +
            "java_package 'redstorm.proxy'\n" +
            "\n" +
            "# the Spout class is a proxy to the real spout to avoid having to deal with all the\n" +
            "# Java artifacts when creating a spout.\n" +
            "\n" +
            "class BatchSpout\n" +
            "  java_implements IBatchSpout\n" +
            "\n" +
            "  java_signature 'IBatchSpout (String base_class_path, String real_spout_class_name)'\n" +
            "  def initialize(base_class_path, real_spout_class_name)\n" +
            "    @real_spout = Object.module_eval(real_spout_class_name).new\n" +
            "  rescue NameError\n" +
            "    require base_class_path\n" +
            "    @real_spout = Object.module_eval(real_spout_class_name).new\n" +
            "  end\n" +
            "\n" +
            "  java_signature 'void open(Map, TopologyContext)'\n" +
            "  def open(conf, context)\n" +
            "    @real_spout.open(conf, context) if @real_spout.respond_to?(:open)\n" +
            "  end\n" +
            "\n" +
            "  java_signature 'void emitBatch(long, TridentCollector)'\n" +
            "  def emitBatch(batch_id, collector)\n" +
            "  	@real_spout.emit_batch(batch_id, collector)\n" +
            "  end\n" +
            "\n" +
            "  java_signature 'void close()'\n" +
            "  def close\n" +
            "    @real_spout.close if @real_spout.respond_to?(:close)\n" +
            "  end\n" +
            "\n" +
            "  java_signature 'void ack(long)'\n" +
            "  def ack(batch_id)\n" +
            "    @real_spout.ack(batch_id) if @real_spout.respond_to?(:ack)\n" +
            "  end\n" +
            "\n" +
            "  java_signature 'Fields getOutputFields()'\n" +
            "  def getOutputFields()\n" +
            "    @real_spout.get_output_fields\n" +
            "  end\n" +
            "\n" +
            "  java_signature 'Map<String, Object> getComponentConfiguration()'\n" +
            "  def getComponentConfiguration\n" +
            "    @real_spout.get_component_configuration\n" +
            "  end\n" +
            "\n" +
            "end\n" +
            "").toString();
        __ruby__.executeScript(source, "/root/.rbenv/versions/jruby-1.7.4/lib/ruby/gems/shared/gems/redstorm-0.6.6/lib/red_storm/proxy/batch_spout.rb");
        RubyClass metaclass = __ruby__.getClass("BatchSpout");
        metaclass.setRubyStaticAllocator(BatchSpout.class);
        if (metaclass == null) throw new NoClassDefFoundError("Could not load Ruby class: BatchSpout");
        __metaclass__ = metaclass;
    }

    /**
     * Standard Ruby object constructor, for construction-from-Ruby purposes.
     * Generally not for user consumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    private BatchSpout(Ruby ruby, RubyClass metaclass) {
        super(ruby, metaclass);
    }

    /**
     * A static method used by JRuby for allocating instances of this object
     * from Ruby. Generally not for user comsumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    public static IRubyObject __allocate__(Ruby ruby, RubyClass metaClass) {
        return new BatchSpout(ruby, metaClass);
    }

    
    public  BatchSpout(String base_class_path, String real_spout_class_name) {
        this(__ruby__, __metaclass__);
        IRubyObject ruby_base_class_path = JavaUtil.convertJavaToRuby(__ruby__, base_class_path);
        IRubyObject ruby_real_spout_class_name = JavaUtil.convertJavaToRuby(__ruby__, real_spout_class_name);
        Helpers.invoke(__ruby__.getCurrentContext(), this, "initialize", ruby_base_class_path, ruby_real_spout_class_name);

    }

    
    public void open(Map conf, TopologyContext context) {
        IRubyObject ruby_conf = JavaUtil.convertJavaToRuby(__ruby__, conf);
        IRubyObject ruby_context = JavaUtil.convertJavaToRuby(__ruby__, context);
        IRubyObject ruby_result = Helpers.invoke(__ruby__.getCurrentContext(), this, "open", ruby_conf, ruby_context);
        return;

    }

    
    public void emitBatch(long batch_id, TridentCollector collector) {
        IRubyObject ruby_batch_id = JavaUtil.convertJavaToRuby(__ruby__, batch_id);
        IRubyObject ruby_collector = JavaUtil.convertJavaToRuby(__ruby__, collector);
        IRubyObject ruby_result = Helpers.invoke(__ruby__.getCurrentContext(), this, "emitBatch", ruby_batch_id, ruby_collector);
        return;

    }

    
    public void close() {

        IRubyObject ruby_result = Helpers.invoke(__ruby__.getCurrentContext(), this, "close");
        return;

    }

    
    public void ack(long batch_id) {
        IRubyObject ruby_batch_id = JavaUtil.convertJavaToRuby(__ruby__, batch_id);
        IRubyObject ruby_result = Helpers.invoke(__ruby__.getCurrentContext(), this, "ack", ruby_batch_id);
        return;

    }

    
    public Fields getOutputFields() {

        IRubyObject ruby_result = Helpers.invoke(__ruby__.getCurrentContext(), this, "getOutputFields");
        return (Fields)ruby_result.toJava(Fields.class);

    }

    
    public Map<String, Object> getComponentConfiguration() {

        IRubyObject ruby_result = Helpers.invoke(__ruby__.getCurrentContext(), this, "getComponentConfiguration");
        return (Map)ruby_result.toJava(Map.class);

    }

}
